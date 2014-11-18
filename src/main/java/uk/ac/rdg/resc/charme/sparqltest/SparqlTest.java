package uk.ac.rdg.resc.charme.sparqltest;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.Syntax;

public class SparqlTest {

	public static void main(String[] args) {
		//String queryString = "SELECT DISTINCT ?a ?b ?c WHERE {  ?a ?b ?c .} LIMIT 25 OFFSET 0";
		//String service = "http://linkedgeodata.org/sparql";
		String queryString = "SELECT ?s { ?s ?p ?o . } LIMIT 10";
		String service = "http://test.strabon.di.uoa.gr/NOA/Query"; 
		Query query = QueryFactory.create(queryString);
		query.setSyntax(Syntax.syntaxARQ);	
		QueryExecution qe = QueryExecutionFactory.sparqlService(service, query);
				
		ResultSet results = qe.execSelect();
		
		while(results.hasNext()) {
			QuerySolution solution = results.nextSolution();
			System.out.println(solution.toString());
		}
		
	}

}

