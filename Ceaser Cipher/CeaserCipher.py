import time
import os

print("Hello and welcome to the Ceaser Ciphter Application!")
#application start prompt
print("Would you like to start the Cipher Application? (yes/no)")
prog = input(": ")

#user defined function for decryption
def decryption(key):
  output = []
  for character in message:
      #Text to ordinal
      number = ord(character)
      if number < 65: output.append(chr(number))
      else:
        number = number - key
        if number < 97: number = (number - 97) + 122
        output.append(chr(number))
  #moving numbers backwards using the decryption key aconverting back into text
  result = ''.join(output)
  print (result)

#user defined function for encryption
def encryption(key): 
  output = []
  for character in message:
      #Text to ordinal
      number = ord(character)
      if number < 65: output.append(chr(number))
      else:
        number = number + key
        if number > 122: number = (number - 122) + 97
        output.append(chr(number))
  #moving numbers over using the key and converting bainto text. ''.join function works to remove list   format and print the text how it was entered
  result = ''.join(output)
  print (result)

if prog == "yes" or prog == "y" or prog == "yea" or prog == "yeah":
    print("You have chosen to start the application")
    print()
    print("Would you like to encrypt or decrypt your message? (enc/dec)")
    choose = input(": ")
    
    #ENCRYPTION SEGMENT !!!
    #CODE FOR ENCRYPTION CHOICE
    if choose == "enc" or "encrypt":
        print("You have chosen to encrypt a message using Ceaser Cipher")
        print()
        key = int(input("Please enter your key for encryption: "))
        print("Please enter the message that you want to encrypt")
        message = input(": ").lower()
        encryption(key)
        print("Please note down or copy your encrypted message before the console clears in 10 seconds")
        time.sleep(10)
        os.system('cls')

    #CODE FOR DECRYPTION CHOICE    
    elif choose == "dec" or "decipher" or "decrypt":
        print("You have chosen to decrypt a message using Ceaser Cipher")
        key = int(input("Please enter your key for decryption: "))
        print("Please enter the message that you want to decrypt ")
        message = input(": ").lower()
        decryption(key)
        print("Please note down or copy your decrypted message before the console clears in 10 seconds")
        time.sleep(10)
        os.system('cls')
    
    print("")
    print("This application will now close to protect your privacy.")
    exit()
else:
    print("Thank you for using the app")
