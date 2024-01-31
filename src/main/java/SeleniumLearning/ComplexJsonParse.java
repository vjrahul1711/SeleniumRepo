package SeleniumLearning;

import common.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args){
        JsonPath js3 = new JsonPath(payload.dummyjson());
        //1. Print No of courses returned by API
        int count = js3.getInt("courses.size()");
        System.out.println("count of courses is "+ count);
        //Print Purchase Amount
        String purchace_amount = js3.getString("dashboard.purchaseAmount");
        System.out.println("Purchase amount is "+purchace_amount);
        //Print Title of the first course
        String first_course = js3.getString("courses[0].title");
        System.out.println("First course name is "+first_course);
        //Print All course titles and their respective Prices

        /*for(int i=0;i<count;i++){
            String courseTitle = js3.get("courses["+i+"].title");
            System.out.println(courseTitle);
            int coursePrice = js3.getInt("courses["+i+"].price");
            System.out.println(coursePrice);
        }*/
        //Print no of copies sold by RPA Course
        for(int i=0;i<count;i++){
            String courseTitle = js3.get("courses["+i+"].title");
            System.out.println("testing");

            if(courseTitle.equalsIgnoreCase("RPA"))
            {
                int courseCopies = js3.getInt("courses["+i+"].copies");
                System.out.println("....."+courseTitle);
                System.out.println(courseCopies);
                break;

            }


        }


    }




}
