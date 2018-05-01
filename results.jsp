<body style="background-color:#428bca;">
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "javax.json.*" %>
<%@ page import = "java.net.*" %>
<%@ page import = "json.*" %>
<!-- directive elements -->

<!-- <h3 id="searchHeader" style="color:#428bca; text-align: center; font-style: italic; margin-top: 50px; font-family:sans-serif;"></h3> -->
<jsp:useBean id="searchquery" class="movierater.username" scope="request"></jsp:useBean>

<!-- scriplet for parsing query string -->
 <%
 		String query = "";
        if("GET".equalsIgnoreCase(request.getMethod()) && request.getParameter("search") != null) {
        	searchquery.setQuery(request.getParameter("search"));
			query = searchquery.getQuery();
			if(query != null) {
				query = query.replaceAll(" ", "%20");
			}
        }
    %>

<div class="search-container" > 
	<%
		URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=d8ebb2ba8120f9103e88ee3396977051&query=" + query);
		try (InputStream is = url.openStream();
	       JsonReader rdr = Json.createReader(is)) {
	 
	      JsonObject obj = rdr.readObject();
	      JsonArray results = obj.getJsonArray("results");
	%>
	 <ul class="list-group" style="margin-left: 200px; margin-right: 200px; margin-top: 75px;">
    <% for (JsonObject result : results.getValuesAs(JsonObject.class)) { %>
       <a href="#" class="list-group-item" style="background-color:black; border: 2px solid white;">
		<div class="d-flex w-100 justify-content-between">
        <section style="margin-right: 100px;">
         <h5 class="mb-1" style="color: gold;"><%=result.getString("title")%></h5>  <!-- used expression here!!!-->
         <small class="mb-1" style="color: white;">Release date: <%=result.getString("release_date")%></small>
         <p class="mb-1" style="color: white;"> <%=result.getString("overview")%></p>
        </section>
      <% String poster = "https://image.tmdb.org/t/p/w300/" + result.getString("poster_path"); %>
      <img src="<%=poster%>">
    </div>
       </a>
    <% } %>
    <% } catch (Exception e) { 

	}%>
    </ul>
</div>
<script>
    //displays the search term
    document.addEventListener('DOMContentLoaded', function() {
        var search = window.location.search.split("="); //splits at '='
        var final = search[1].split("+"); //parses string
        var string = "";
        for(i=0; i < final.length; i++) { //adds all the words together
            string+=final[i] + " "
        }
        console.log(string);
        console.log(final);
        var text = document.createTextNode(string);
        document.getElementById("searchHeader").appendChild(text);


    });     
</script>