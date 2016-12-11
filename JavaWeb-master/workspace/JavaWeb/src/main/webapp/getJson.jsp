<%@page contentType="application/json; charset=UTF-8"%>
<%@page import="org.json.JSONObject"%>
<%

    JSONObject json = new JSONObject();

    json.put("amount","55.00");
    json.put("tax","1.00");

    out.println(json.toString());
    out.close();
%>