<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<html>
<head>
    <title>JSTL x:transform Tags</title>
</head>
<body>
    <h3>Books Info:</h3>
    <c:set var="xmltext">
        <books>
            <book> 
                <name>JSTL by Example</name> 
                <author>Juan Perez</author> 
                <price>100</price>
            </book> 
            <book> 
                <name>XSLT Advanced</name> 
                <author>Jose Lopez</author> 
                <price>2000</price> 
            </book> 
        </books>
    </c:set>

    <%-- http://localhost:9090/JavaWeb/xslt/xsltExample.xsl --%>
    <c:import url="/xslt/xsltExample.xsl" var="xslt" />
    <x:transform xml="${xmltext}" xslt="${xslt}" />
    
</body>
</html>