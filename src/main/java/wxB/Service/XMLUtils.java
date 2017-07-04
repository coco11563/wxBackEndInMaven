package wxB.Service;

import org.dom4j.Attribute;
import org.dom4j.Element;
import wxB.POJO.content.rec.recContent;
import wxB.POJO.content.recMsgTypeEnum;
import wxB.POJO.content.ret.retContent;
import wxB.POJO.content.sendMsgTypeEnum;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by coco1 on 2017/6/17.
 */
public class XMLUtils {
    public void listNodes(Element node){
        System.out.println("当前节点的名称：" + node.getName());
        //首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        //遍历属性节点
        for(Attribute attribute : list){
            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());
        }
        //如果当前节点内容不为空，则输出
        if(!(node.getTextTrim().equals(""))){
            System.out.println( node.getName() + "：" + node.getText());
        }
        //同时迭代当前节点下面的所有子节点
        //使用递归
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodes(e);
        }
    }
    /**
     * xml 数据转换对象
     *
     * @param rootElt
     *            要转换的Element数据
     * @param pojo
     *            要转换的目标对象类型
     * @return 转换的目标对象
     * @throws Exception
     *             转换失败
     */
    @SuppressWarnings("rawtypes")
    public Object fromXmlToBean(Element rootElt, Class pojo) throws Exception
    {
        // 首先得到pojo所定义的字段
        Field[] fields = pojo.getDeclaredFields();
        // 根据传入的Class动态生成pojo对象
        Object obj = pojo.newInstance();
        String type = rootElt.elementText("MsgType");
        for (Field field : fields)
        {
            // 设置字段可访问（必须，否则报错）
            field.setAccessible(true);
            // 得到字段的属性名
            String name = field.getName();
            // 这一段的作用是如果字段在Element中不存在会抛出异常，如果出异常，则跳过。
            try
            {
                rootElt.elementTextTrim(name);
            }
            catch (Exception ex)
            {
                continue;
            }
            if (rootElt.elementTextTrim(name) != null && !"".equals(rootElt.elementTextTrim(name)))
            {
                // 根据字段的类型将值转化为相应的类型，并设置到生成的对象中。
                if (field.getType().equals(Long.class) || field.getType().equals(long.class))
                {
                    field.set(obj, Long.parseLong(rootElt.elementTextTrim(name)));
                }
                else if (field.getType().equals(String.class))
                {
                    field.set(obj, rootElt.elementTextTrim(name));
                }
                else if (field.getType().equals(Double.class) || field.getType().equals(double.class))
                {
                    field.set(obj, Double.parseDouble(rootElt.elementTextTrim(name)));
                }
                else if (field.getType().equals(Integer.class) || field.getType().equals(int.class))
                {
                    field.set(obj, Integer.parseInt(rootElt.elementTextTrim(name)));
                }
                else if (field.getType().equals(Date.class))
                {
                    field.set(obj, Date.parse(rootElt.elementTextTrim(name)));
                }
                else if (field.getType().equals(recContent.class)) {
                    field.set(obj, recContent.parseRecContent(rootElt, recMsgTypeEnum.valueOf(type)));
                } else if (field.getType().equals(retContent.class)) {
                field.set(obj, retContent.parseSendContent(rootElt, sendMsgTypeEnum.valueOf(type)));
            } else
                {
                    continue;
                }
            }
        }
        return obj;
    }


    public String formBeanToXML (Object s) {
        StringWriter sw = new StringWriter();
        JAXBContext jbc=null;
        Marshaller mar=null;
        try {
            jbc = JAXBContext.newInstance(s.getClass());   //传入要转换成xml的对象类型
            mar = jbc.createMarshaller();
            mar.marshal(s, sw);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sw.toString().replace("&lt;", '<'+"").replace("&gt;", '>'+"");
    }

    /**
     * JavaBean转换成xml
     * @param obj
     * @param encoding
     * @return
     */
    public String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
