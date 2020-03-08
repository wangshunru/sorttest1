///*
//package json;
//
//
//import com.jayway.jsonpath.JsonPath;
//
//*/
///**
// * Created by wangshunxi on 2019/12/11.
// * e-mail: mcphilex1989@gmail.com
// * phone: 15652608401
// *//*
//
//public class TestJson {
//    public static void main(String[] args) {
//
//        String json = "{\n" +
//                "    \"code\":\"000000\",\n" +
//                "    \"message\":\"项目扫描完成\",\n" +
//                "    \"project\":{\n" +
//                "        \"environment\":\"PL4\",\n" +
//                "        \"system\":\"N-SDD\",\n" +
//                "        \"subSystem\":\"N-SDD\",\n" +
//                "        \"service\":\"N-SDD_AP\",\n" +
//                "        \"creator\":\"ligang7.zh\",\n" +
//                "        \"startDate\":{\n" +
//                "            \"month\":\"DECEMBER\",\n" +
//                "            \"year\":2019,\n" +
//                "            \"dayOfMonth\":4,\n" +
//                "            \"hour\":15,\n" +
//                "            \"minute\":42,\n" +
//                "            \"monthValue\":12,\n" +
//                "            \"nano\":513000000,\n" +
//                "            \"second\":43,\n" +
//                "            \"dayOfWeek\":\"WEDNESDAY\",\n" +
//                "            \"dayOfYear\":338,\n" +
//                "            \"chronology\":{\n" +
//                "                \"id\":\"ISO\",\n" +
//                "                \"calendarType\":\"iso8601\"\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"endDate\":{\n" +
//                "            \"month\":\"DECEMBER\",\n" +
//                "            \"year\":2019,\n" +
//                "            \"dayOfMonth\":4,\n" +
//                "            \"hour\":15,\n" +
//                "            \"minute\":42,\n" +
//                "            \"monthValue\":12,\n" +
//                "            \"nano\":473000000,\n" +
//                "            \"second\":59,\n" +
//                "            \"dayOfWeek\":\"WEDNESDAY\",\n" +
//                "            \"dayOfYear\":338,\n" +
//                "            \"chronology\":{\n" +
//                "                \"id\":\"ISO\",\n" +
//                "                \"calendarType\":\"iso8601\"\n" +
//                "            }\n" +
//                "        },\n" +
//                "        \"memo\":\"\",\n" +
//                "        \"version\":\"1.0.1.25\",\n" +
//                "        \"totalCount\":6,\n" +
//                "        \"invalidCount\":6,\n" +
//                "        \"correctedCount\":0\n" +
//                "    },\n" +
//                "    \"details\":{\n" +
//                "        \"1000\":[\n" +
//                "            {\n" +
//                "                \"container\":\"test.jar\",\n" +
//                "                \"clazz\":\"com.company.Main\",\n" +
//                "                \"method\":\"main\",\n" +
//                "                \"source\":\"Main.java\",\n" +
//                "                \"line\":21,\n" +
//                "                \"valid\":false\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"2000\":[\n" +
//                "            {\n" +
//                "                \"container\":\"test.jar\",\n" +
//                "                \"clazz\":\"com.company.Main\",\n" +
//                "                \"method\":\"main\",\n" +
//                "                \"source\":\"Main.java\",\n" +
//                "                \"line\":23,\n" +
//                "                \"valid\":false\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"3000\":[\n" +
//                "            {\n" +
//                "                \"container\":\"test.jar\",\n" +
//                "                \"clazz\":\"com.company.Main\",\n" +
//                "                \"method\":\"main\",\n" +
//                "                \"source\":\"Main.java\",\n" +
//                "                \"line\":25,\n" +
//                "                \"valid\":false\n" +
//                "            }\n" +
//                "        ]\n" +
//                "    }\n" +
//                "}";
//
//        Object read = JsonPath.read(json, "$.code");
//        System.out.println("code ："+read);
//        Object environment = JsonPath.read(json, "$.project.environment");
//        System.out.println("environment is "+environment);
//        Object system = JsonPath.read(json, "$.project.system");
//        String startDate = JsonPath.read(json, "$.project.startDate.year") + "-" +
//                JsonPath.read(json, "$.project.startDate.monthValue") + "-" +
//                JsonPath.read(json, "$.project.startDate.dayOfMonth") + " " +
//                JsonPath.read(json, "$.project.startDate.hour") + ":" +
//                JsonPath.read(json, "$.project.startDate.minute") + ":" +
//                JsonPath.read(json, "$.project.startDate.second");
//        Object read1 = JsonPath.read(json, "$.details");
//        System.out.println(read1);
//        System.out.println(startDate);
//    }
//}
//*/
