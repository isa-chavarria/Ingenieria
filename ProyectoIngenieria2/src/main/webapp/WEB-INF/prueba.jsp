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

        <div>
            
            <input   id="valor" type="hidden">
            
            
            <input type="text"  id="w-input-search" value="">
            
            <span>
                <button id="w-button-search" onclick="jaja()" type="button">Search</button>
            </span>
        </div>

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