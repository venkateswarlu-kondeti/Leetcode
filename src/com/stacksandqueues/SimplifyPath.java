package com.stacksandqueues;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public static String simplifyPath(String path){
        StringBuilder stack=new StringBuilder();
        String[] parts=path.split("/+");
        List<String> strList=new ArrayList<>();
        for(String part : parts){
            if(!part.equals(".") && !part.equals("..") && !part.equals("")){
                strList.add(part);
            }else if(part.equals("..") && strList.size()>0){
                strList.remove(strList.size()-1);
            }
        }
        if(!strList.isEmpty()){
            for(String str:strList){
                stack.append("/");
                stack.append(str);
            }
        }else{
            stack.append("/");
        }
        return stack.toString();
    }
    public static void main(String[] args){
        //String path="/home/////../My/..//high/..";
        //String path="/../";
        //String path="/home//foo/";
        //String path="/home/";
        String path="/a/./b/../../c/";
        System.out.println("The simplified path is: "+simplifyPath(path));
    }
}
