package example.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {

    public static void main(String args[]){
        System.out.println("Hello Java");

        ObjectMapper mapper = new ObjectMapper();

        AA aa = new AA("a1","a2","a3");


        ABCall all1 = new ABCall("a1","a2","a3","b1","b21","b3","c1","c21","c31");
        ABCall all2 = new ABCall("a1","a2","a3","b1","b21","b3","c1","c21","c32");
        ABCall all3 = new ABCall("a1","a2","a3","b1","b21","b3","c1","c21","c33");
        ABCall all4 = new ABCall("a1","a2","a3","b1","b22","b3","c1","c22","c34");
        ABCall all5 = new ABCall("a1","a2","a3","b1","b22","b3","c1","c22","c35");
        ABCall all6 = new ABCall("a11","a22","a33","b1","b2","b3","c1","c2","c34");
/*
[
{"a1":"a1","a2":"a2","a3":"a3"
,"b":[
      {"b1":"b1","b2":"b21","b3":"b3"
     ,"c":[
               {"c1":"c1","c2":"c21","c3":"c31"}
                ,{"c1":"c1","c2":"c21","c3":"c32"}
                ,{"c1":"c1","c2":"c21","c3":"c33"}
     ]}
      ,{"b1":"b1","b2":"b22","b3":"b3"
         ,"c":[
                 {"c1":"c1","c2":"c21","c3":"c34"}
                 ,{"c1":"c1","c2":"c21","c3":"c35"}
              ]}
   ]}
,{"a1":"a1","a2":"a2","a3":"a3","b":[{"b1":"b1","b2":"b2","b3":"b3" , "C":[{"c1":"c1","c2":"c2","c3":"c3"}]}]}
]


 */
        ArrayList<ABCall> abcAllList = new ArrayList<ABCall>();
        abcAllList.add(all1);
        abcAllList.add(all2);
        abcAllList.add(all3);
        abcAllList.add(all4);
        abcAllList.add(all5);
        abcAllList.add(all6);

        System.out.println(abcAllList.toArray());

        //Map<ABCObject, List<ABCObject>> userByDepartment = abcAllList.stream().collect(groupingBy(list -> new ABCObject(list.getA())));


        Map<String, Object> data = new HashMap<>();
        data.put("data", abcAllList);

        for( int i=0 ; i < abcAllList.size() ; ++i ){
            ABCObject obj = new ABCObject();
            ModelMapper modelMapper = new ModelMapper();

            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD) ;
            if ( i == 0 ){
                obj = modelMapper.map(abcAllList.get(0), ABCObject.class);
                System.out.println(obj.toString());
                try {
                    String jsonString = mapper.writeValueAsString(obj);
                    System.out.println("jsonString" +  jsonString);
                } catch (Exception e) {
                    System.out.println("bObj getMessage=" +   e.getMessage());
                }


                BBObject bObj = new BBObject();
                bObj = modelMapper.map(abcAllList.get(0), BBObject.class);

                List<BBObject> b = new ArrayList<>();
                b.add(bObj);
                obj.setB(b);


                try {
                    String jsonString1 = mapper.writeValueAsString(obj);
                    System.out.println("bObj=" +  jsonString1);
                } catch (Exception e) {
                    System.out.println("bObj getMessage=" +   e.getMessage());

                }

                  //obj.setB( modelMapper.map(abcAllList.get(0), BB.class) );


            }

        }

        try {
//            String json = new ObjectMapper().writeValueAsString(data);
//            System.out.println(json);

            String jsonString = mapper.writeValueAsString(abcAllList); //List -> JSONString
            System.out.println(jsonString);

        } catch (Exception e) {
            e.getMessage();
        }
//
//        String json = new ObjectMapper().writeValueAsString(data);
//
//        ABCall result = mapper.convertValue(data,ABCall.class);
    }
}
