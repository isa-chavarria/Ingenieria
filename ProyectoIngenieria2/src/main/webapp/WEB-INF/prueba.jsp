<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>


        <script src="resources/js/jquery.1.10.2.min.js"></script>
        <script src="resources/js/jquery.autocomplete.min.js"></script>

    </head>
    <body>
        <h2>Spring MVC + jQuery + Autocomplete example</h2>

        <form:form method="POST" action="cargarArchivo" modelAttribute="mensaje" enctype="multipart/form-data" class="form-horizontal">

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="file">Upload a document</label>
                    <div class="col-md-7">
                        <form:input type="file" path="file" id="file" class="form-control input-sm"/>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="file">Description</label>
                    <div class="col-md-7">
                        <form:input type="text" path="mensaje" id="description" class="form-control input-sm"/>
                    </div>

                </div>
            </div>

            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                </div>
            </div>

        </form:form>




        <a type="button" href="<c:url value='/download-document' />" class="btn btn-success custom-width">download</a>

        <!--div>
            
            <input   id="valor" type="hidden">
            
            
            <input type="text"  id="w-input-search" value="">
            
            <span>
                <button id="w-button-search" onclick="jaja()" type="button">Search</button>
            </span>
        </div-->

        <script>



            $(document).ready(function () {

                $('#w-input-search').autocomplete({
                    serviceUrl: 'getTags',
                    paramName: "tagName",
                    delimiter: ",",
                    transformResult: function (response) {

                        return {
                            suggestions: $.map($.parseJSON(response), function (item) {
                                return {value: item.tagName, data: item.id};
                            })

                        };

                    }

                });


            });
        </script>

    </body>
</html>