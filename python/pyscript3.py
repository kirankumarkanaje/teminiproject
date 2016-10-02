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
	'/placeorder', 'place_order',
	'/showorders/(.*)', 'show_orders',
	'/getorderdetails/(.*)','get_order_details'
	
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
       
       returnuserid = ''			 
			 
       for(User_ID , user_name, password) in cursor:
           returnuserid = User_ID
           count +=1
			 
       cursor.close()
       con.close()
		 
       response = "FAIL"
		 	 
       if count == 0:
           response = "FAIL"
       else:
           response = "SUCCESS" 
           
       user_json={}
       user_json['user_id']=returnuserid
       user_json['status']=response    
       return json.dumps(user_json)


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
       returnvendorid = ''

			 
       for(v_id , v_username, v_password) in cursor:
         returnvendorid = v_id
         count +=1
			 
       cursor.close()
       con.close()
		 
       response = "FAIL"
		 	 
       if count == 0:
           response = "FAIL"
       else:
           response = "SUCCESS" 
       
       vendor_json={}
       vendor_json['vendor_id']=returnvendorid
       vendor_json['status']=response  
       print json.dumps(vendor_json)  
       return json.dumps(vendor_json)
    	

class place_order:
    def POST(self):
       data = web.data()
       print "=================================="
       print str(data)
       print "=================================="
       jsondata = json.loads(data)
       userid= jsondata["user_id"]
       restaurantid= jsondata["restaurant_id"]
       totalAmount= jsondata["total_amount"]
       con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
       cursor = con.cursor(buffered=True)
       query = ("insert into ordertable(u_id,R_ID,total,DateAndTime) values({},{},{}, NOW())".format(userid,restaurantid,totalAmount))
       print "Query: "+ query
       cursor.execute(query)
       con.commit()
       
       query = ("select o_id from ordertable order by o_id DESC")
       cursor.execute(query)
       orderid=-1
       for(o_id) in cursor:
			orderid=o_id
			break

       itemids = jsondata["item_ids"]
       for item_id in itemids:
           query = ("insert into orders(o_id, R_ID, u_id, Item_ID) values({},{},{},{})".format(orderid[0], restaurantid, userid, item_id))
           print "Executing query: " + query
           cursor.execute(query)
           
       con.commit()

       cursor.close()
       con.close()
       
       
class show_orders:
	def GET(self, ID):
		json_data = []
		con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
		cursor = con.cursor()
		query = ("select * from ordertable where R_ID = {} and status = 'PENDING' order by o_id DESC".format(ID))
		print "Query: " + query
		cursor.execute(query)
		
		for(o_id, u_id, R_ID, total, dateAndTime, status) in cursor:
			data = {}
			data['orderid'] =o_id
			data['u_id'] = u_id
			data['u_name'] = self.get_user_name(u_id)
			data['R_ID'] = R_ID
			data['total'] = total
			data['time']= dateAndTime
			data['status'] = status 
			json_data.append(data)
			
		cursor.close()
		con.close()

		order_json = {}
		order_json['order'] = json_data
		print str(json.dumps(order_json))
		return json.dumps(order_json)
		
	def get_user_name(self, u_id):
		username = u_id
		con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
		cursor = con.cursor()
		query = ("select user_name from usertable where u_id = {}".format(u_id))
		print "Query: " + query
		cursor.execute(query)
		
		for(user_name) in cursor:
			username = user_name[0]
			break
		
		cursor.close()
		con.close()
		
		return username
		

class get_order_details:
	def GET(self, order_id):
		json_data = []
		con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
		cursor = con.cursor()
		query = ("select * from orders where o_id = {}".format(order_id))
		print "Query: " + query
		cursor.execute(query)
		
		for(o_id,Item_Name, R_ID, u_id, Item_ID) in cursor:
			item = self.get_item(Item_ID)
			json_data.append(item)
			
		cursor.close()
		con.close()
			
		details_json = {}
		details_json['orderdetails'] = json_data
		print str(json.dumps(details_json))
		return json.dumps(details_json)
		
		
	def get_item(self, item_id):
		con = mysql.connector.connect(user = 'root', password = 'root', database = 'food')
		cursor = con.cursor()
		query = ("select Item_ID,Item_Name,Item_Price from Menu where Item_ID = {}".format(item_id))
		print "Query: " + query
		cursor.execute(query)
		
		item = {}
		for(Item_ID, Item_Name, Item_Price) in cursor:
			item['item_name'] = Item_Name 
			item['item_cost'] = Item_Price
			item['item_id'] = Item_ID
			break
		
		cursor.close()
		con.close()
		return item

if __name__=="__main__":
	app.run()
