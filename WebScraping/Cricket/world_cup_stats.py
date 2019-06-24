from urllib.request import urlopen
from bs4 import BeautifulSoup as soup
from prettytable import PrettyTable

destination_url = "https://www.cricketworldcup.com/standings"

uClient = urlopen(destination_url)
page_html = uClient.read()
uClient.close()

page_soup = soup(page_html, "html.parser")

containers = page_soup.findAll("tr", {"class":"table-body"})

#print("Position\tTeam Name\t\tPlayed\tWon\tLost\tN/R\tTied\tPoints")

table = PrettyTable()
table.field_names = ["Position", "Team Name", "Played", "Won", "Lost", "N/R", "Tied", "Points"]

count = 1
for container in containers:
	#team name and symbol
	team_name = container.a.span.text.strip()
	team_symbol = container.a.span.next_sibling.next_sibling.text.strip()

	games_played = container.td.next_sibling.next_sibling.next_sibling.next_sibling.text
	games_won = container.td.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.text
	games_lost = container.td.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.text
	games_not_played = container.td.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.text
	games_tied = container.td.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.text

	#net_rr = container.td.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.text

	points = container.td.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.next_sibling.text

	#print(f"{count}\t\t{team_name} ({team_symbol})\t{games_played}")
	table.add_row([count, team_name + " (" + team_symbol + ")", games_played, games_won, games_lost, games_not_played, games_tied, points])
	count += 1

print(table)