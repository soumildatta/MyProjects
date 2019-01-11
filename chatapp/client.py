import socket
import sys
import time
import regex as re

s = socket.socket()
host = input("Enter the host server name: ")
#make another input for port
#port = 8080

try:
	port = int(input("Enter a port number: "))
except ValueError:
	port = ""
	while port.isdigit() == False:
		port = (input("Please enter only numbers: "))
finally:
	port = int(port)

print("")

name = input("Enter your chat username: ")
'''

if(re.search('[a-zA-Z]', port)):
	print("Wrong")
'''
try:
	s.connect((host, port))
except Exception:
	print("Failed to connect to server")
	exit()

print("Connected to chat server")

######################################
#send username
name = name.encode()
s.send(name)
print("Username has been established")
######################################
#receive username
nameReceive = s.recv(1024)
nameReceived = nameReceive.decode()
######################################

while 1:
	incomingMessage = s.recv(1024)
	incomingMessage = incomingMessage.decode()
	print(nameReceived + ": " + incomingMessage)
	message = input(str(">>"))
	#interface of socket only supports bytes
	message = message.encode()
	s.send(message)
	print("message has sent...")
	print("")

