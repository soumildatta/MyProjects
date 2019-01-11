import socket
import sys
import time


s = socket.socket()
host = socket.gethostname()
print("Starting server on host: " + host)

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

#server binding
s.bind((host, port))
print("")

print("Waiting for connection")
print("")
s.listen(1)

conn, addr = s.accept()
print(str(addr) + " has established a connection!")
print("")


######################################
#send username
name = name.encode()
conn.send(name)
print("Username has been established")
######################################
#receive username
nameReceive = conn.recv(1024)
nameReceived = nameReceive.decode()
######################################


#default exit keyword
exit = "exit()"

message = ""
while message != exit: #while loop not working
	message = input(str(">>"))
	#interface of socket only supports bytes
	message = message.encode()
	conn.send(message)
	print("message has sent...")
	print("")

	incomingMessage = conn.recv(1024)
	incomingMessage = incomingMessage.decode()
	print(nameReceived + ": " + incomingMessage)

