#!/usr/bin/env python
import web
import mysql.connector
import json

urls = (
	'/restaurants/(.*)', 'get_restaurant',
	'/menu/(.*)' , 'get_menu',
	'/login', 'login',
	'/signup', 'signup',
	'/vsignup', 'get_vsignup',
	'/vsignin', 'get_vsignin',
	'/allorders', 'get_allorders',
	'/orders' , 'postorders'
	)

app = web.application(urls, globals())


class get_restaurant:
	def GET(self, Type):
		json_data = []
		con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
		cursor = con.cursor()
		query = ("select * from Restaurants where R_Type = '{}'".format(Type))
		print "Query: " + query
		cursor.execute(query)

		for(R_ID,R_Name,R_Type,R_Location) in cursor:
			data = {}
			data['id'] = R_ID 
			data['name'] = R_Name
			data['Type'] = R_Type
			data['Location'] = R_Location
			json_data.append(data)
			
		cursor.close()
		con.close()

		restaurants_json = {}
		restaurants_json['restaurants'] = json_data
 		return json.dumps(restaurants_json)

class get_menu:
	def GET(self, ID):
		json_data = []
		con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
		cursor = con.cursor()
		query = ("select * from Menu where R_ID = '{}'".format(ID))
		print "Query: " + query
		cursor.execute(query)
		
		for(Item_ID, Item_Name, Item_Price, Item_Type, Item_Category, R_ID) in cursor:
			data = {}
			data['iid'] =Item_ID
			data['iname'] = Item_Name
			data['iprice'] = Item_Price
			data['itype'] = Item_Type
			data['icategory'] = Item_Category
			data['id'] = R_ID 
			json_data.append(data)
			
		cursor.close()
		con.close()

		menu_json = {}
		menu_json['menu'] = json_data
		return json.dumps(menu_json)


class login:
    def POST(self):
       data = web.data()
       print "=================================="
       print str(data)
       print "=================================="
       jsondata = json.loads(data)
       username = jsondata["username"]
       password = jsondata["password"]
       count = 0
       con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
       cursor = con.cursor()
       query = ("select * from usertable where user_name = '{}' and password = '{}'".format(username, password)) 
       print "Query: "+ query
       cursor.execute(query)
			 
       for(User_ID , user_name, password) in cursor:
           count +=1
			 
       cursor.close()
       con.close()
		 
       response = "FAIL"
		 	 
       if count == 0:
           response = "FAIL"
       else:
           response = "SUCCESS" 
       return response


class signup:
    def POST(self):
    	data = web.data()
    	print str(data)
    	jsondata = json.loads(data)
    	username = jsondata["username"]
        password = jsondata["password"]
#        count = 0
        con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
        cursor = con.cursor()
        query = ("insert into usertable (user_name, password) values('{}','{}')".format(username, password))
        print "Query: "+ query
        cursor.execute(query)
        con.commit()
        cursor.close()
        con.close()
        
        
#        for(user_id , user_name, password) in cursor:
#           count +=1
			 
        
		 
#        response = "FAIL"
#		 	 
#       if count == 0:
#           response = "FAIL"
#        else:
#          response = "SUCCESS" 
#        return response
        

class get_vsignup:
    def POST(self):
    	data = web.data()
    	print str(data)
    	jsondata = json.loads(data)
    	username = jsondata["username"]
        password = jsondata["password"]
#        count = 0
        con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
        cursor = con.cursor()
        query = ("insert into vendortable (v_username, v_password) values('{}','{}')".format(username, password))
        print "Query: "+ query
        cursor.execute(query)
        con.commit()
        cursor.close()
        con.close()
        
        
class get_vsignin:
    def POST(self):
       data = web.data()
       print "=================================="
       print str(data)
       print "=================================="
       jsondata = json.loads(data)
       username = jsondata["username"]
       password = jsondata["password"]
       count = 0
       con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
       cursor = con.cursor()
       query = ("select * from vendortable where v_username = '{}' and v_password = '{}'".format(username, password)) 
       print "Query: "+ query
       cursor.execute(query)
			 
       for(v_id , v_username, v_password) in cursor:
           count +=1
			 
       cursor.close()
       con.close()
		 
       response = "FAIL"
		 	 
       if count == 0:
           response = "FAIL"
       else:
           response = "SUCCESS" 
       return response
    	

#		menu_json = {}
#		menu_json['menu'] = json_data
#		return json.dumps(menu_json)
if __name__=="__main__":
	app.run()
