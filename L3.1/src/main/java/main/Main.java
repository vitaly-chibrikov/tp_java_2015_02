package main;
 
import java.sql.Connection;

import dao.UsersDAO;

import examples.ConnectWithStatements;
import examples.DataSetExample;
import examples.PreparedExample;
import examples.SimpleExample;
import examples.TExample;


public class Main {
	public static void main(String[] args) {
		SimpleExample.connect();
		//ConnectWithStatements.connect();
		//PreparedExample.connect();
		//TExample.connect();
		//DataSetExample.connect();
		
	}
}
