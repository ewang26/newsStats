# NewsStats

NewsStats is a Java library that is designed to fetch information from a url (primarily Google News and Yahoo News) and analyze the content on the webpage. 
Some features of this library include finding keywords and people names on the page.

### Where the information is coming from

NewsStats is able to access the same SEO terms that Google has availble to it for news articles, meaning that it can extract several times a direct synopsis from there. In addition, NewsStats is able to visit a website itself and extract the first paragraph of a news article to parse for search terms (the idea being that a good reporter will always get to the point in a lede). 

### Dependencies
JSoup is a good tool for extracting html data, and can help parse through certain news articles.
SEMrush’s Analytics API is how NewsStats can get all search term data for any article.
