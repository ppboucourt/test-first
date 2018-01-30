package com.intersection.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;


public class DemoApplicationImpl {

    public static String FizzBuzzStep1(List<Integer> list) {
        try{
            List<String> result = new ArrayList<>();
            list.stream().forEach(value -> {
                //Adding elements under the given criteria
                if(value%15==0) {
                    result.add("fizzbuzz");
                } else{
                    if(value%3==0) {
                        result.add("fizz");
                    } else {
                        if (value % 5 == 0) {
                            result.add("buzz");
                        } else {
                            {
                                result.add(value.toString());
                            }
                        }
                    }
                }
            });
            String values = "";
            int i = 0;
            for (String val: result ) {
                if (i == 0) {
                    values += val;
                }else {
                    values += " " + val;
                }
                i++;
            }
            return values;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String FizzBuzzStep2(List<Integer> list) {
        try{
            List<String> result = fizzBuzzLucky(list);
            return buildResult(result);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String FizzBuzzStep3(List<Integer> list) {
        try{

            List<String> result = fizzBuzzLucky(list);
            String values = buildResult(result);
            HashMap<String, Integer> map = countFizzBuzzLucky(result);
            //Previous line get the HashMap values and next line getting each value by key
            values += "\n" + "fizz: " +map.get("fizz") +
                    " buzz: " +map.get("buzz") +
                    " fizzbuzz: " +map.get("fizzbuzz") +
                    " lucky: " +map.get("lucky") +
                    " integer: " +map.get("integer");
            return values;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> fizzBuzzLucky(List<Integer> list) {
        List<String> result = new ArrayList<>();
        list.stream().forEach(value -> {
            //Adding elements under the given criteria
            if(value.toString().contains("3")) { result.add("lucky");}
            else { if(value%15==0) { result.add("fizzbuzz");}
            else { if(value%3==0) { result.add("fizz");}
            else { if(value%5==0) { result.add("buzz");}
            else { result.add(value.toString());}
            }
            }
            }
        });
        return result;
    }

    public static String buildResult(List<String> data) {
        String values = "";
        int i = 0;
        for (String val: data ) {
            if (i == 0) {
                //add the first element without leave space
                values += val;
            }else {
                //adding and leaving space between the values already in the string and the new ones
                values += " " + val;
            }
            i++;
        }
        return values;
    }

    public static HashMap<String, Integer> countFizzBuzzLucky(List<String> list) {
        //Using Java8 update to filter by "name" and count each time are repeat
        Integer fizz = Math.toIntExact(list.stream().filter(val -> val.equalsIgnoreCase("fizz")).count());
        Integer buzz = Math.toIntExact(list.stream().filter(val -> val.equalsIgnoreCase("buzz")).count());
        Integer fizzbuzz = Math.toIntExact(list.stream().filter(val -> val.equalsIgnoreCase("fizzbuzz")).count());
        Integer lucky = Math.toIntExact(list.stream().filter(val -> val.equalsIgnoreCase("lucky")).count());
        Integer integer = Math.toIntExact(list.stream().filter(val -> isNumeric(val)).count());

        //Initialize HashMap
        HashMap<String, Integer> result = new HashMap<>();
        //Setting to each key it's corresponding value
        result.put("fizz", fizz);
        result.put("buzz", buzz);
        result.put("fizzbuzz", fizzbuzz);
        result.put("lucky", lucky);
        result.put("integer", integer);

        return result;
    }
}
