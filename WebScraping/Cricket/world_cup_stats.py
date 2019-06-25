#author: Soumil Datta
#Description: Displays the current world cup cricket team rankings and stats

from urllib.request import urlopen
from bs4 import BeautifulSoup as soup
from prettytable import PrettyTable

#all information scraped from cricketworldcup.com
destination_url = "https://www.cricketworldcup.com/standings"

#fetch the url using urllib 
uClient = urlopen(destination_url)
page_html = uClient.read()
uClient.close()

#parse html using beautifulsoup
page_soup = soup(page_html, "html.parser")

#tr tags with table-body class contain each team's information
containers = page_soup.findAll("tr", {"class":"table-body"})

#define column labels with pretty table
table = PrettyTable()
table.field_names = ["Position", "Team Name", "Played", "Won", "Lost", "N/R", "Tied", "Points"]

#runs through every tr tag in the containers array to get team info
for container in containers:
	#team name and symbol
	team_name = container.a.span.text.strip()
	team_symbol = container.a.span.next_sibling.next_sibling.text.strip()

	#td tag with the table-body__cell class contains team stats such as games won and lost 
	game_info = container.findAll("td", {"class":"table-body__cell"})

	#get team position, games won, games lost, games not played, games tied, and team points
	pos_team = game_info[0].text.strip()
	games_played = game_info[2].text.strip()
	games_won = game_info[3].text.strip() 
	games_lost = game_info[4].text.strip()
	games_not_played = game_info[5].text.strip() 
	games_tied = game_info[6].text.strip()
	points = game_info[8].text.strip()

	#add row in the table with all the team stats corresponding with their label
	table.add_row([pos_team, team_name + " (" + team_symbol + ")", games_played, games_won, games_lost, games_not_played, games_tied, points])

#print the completed table
print(table)