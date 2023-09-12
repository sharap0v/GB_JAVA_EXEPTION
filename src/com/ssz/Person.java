package com.ssz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private HashMap<String, String> personData;
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Person(String [] dataArray) throws UserDataError {
        personData = new HashMap<>();
        personData.put("middleName", "Нет отчества");
        personData.put("firstName", null);
        personData.put("lastname", null);
        personData.put("birthdate", null);
        personData.put("phoneNumber", null);
        personData.put("gender", null);

        for (String s : dataArray) {
            if (personData.get("gender") == null && checkGender(s)) {
                personData.put("gender", s);
                continue;
            }
            if (personData.get("birthdate") == null && checkBirthdate(s)) {
                personData.put("birthdate", s);
                continue;
            }
            if (personData.get("phoneNumber") == null && checkPhoneNumber(s)) {
                personData.put("phoneNumber", s);
                continue;
            }
            if (personData.get("firstName") == null && checkNameString(s, HW3.FIRST_NAME)) {
                personData.put("firstName", s);
                continue;
            }

            if (personData.get("lastname") == null && checkNameString(s, HW3.LAST_NAME)) {
                personData.put("lastname", s);
                continue;
            }
            if (checkNameString(s, HW3.MIDDLE_NAME)) {
                personData.put("middleName", s);
            }
        }

        StringBuilder checkMessage = new StringBuilder("");
        boolean error = false;
        for (Map.Entry<String,String> p: personData.entrySet()){
            if (p.getValue()==null) {
                error = true;
                checkMessage.append(p.getKey()).append(" ");
            }
        }
        if (error) {
            throw new UserDataError(checkMessage.toString());
        }
    }

    private boolean checkGender(String data) {
        return data.length() == 1 && ("F".equals(data) || "M".equals(data));
    }

    private boolean checkBirthdate(String data) {
        try {
            simpleDateFormat.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean checkPhoneNumber(String data) {
        try {
            Long.parseLong(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkNameString(String data, String[] checkData){
        for (int i = 0; i < checkData.length; i++) {
            if(checkData[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public String getPersonLastname() {
        return personData.get("lastname");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<")
                .append(personData.get("lastname"))
                .append("><")
                .append(personData.get("firstName"))
                .append("><")
                .append(personData.get("middleName"))
                .append("><")
                .append(personData.get("birthdate"))
                .append("><")
                .append(personData.get("phoneNumber"))
                .append("><")
                .append(personData.get("gender"))
                .append(">");
        return sb.toString();
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(simpleDateFormat.parse("1.12.2222"));
    }

}
