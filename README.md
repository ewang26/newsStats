# NewsStats
NewsStats is a Java library that is designed to fetch information from a url (primarily Google News and Yahoo News) and analyze the content on the webpage. 

## Where the Information Comes From
NewsStats accesses the HTML content from different online news sites, such as Google News and Yahoo News. Using jsoup, this library only analyzes the headers in the news pages using the H3 and H4 HTML tags. Thus, NewsStats is able to quickly and cleanly identify the key terms in a news page by ranking the frequency of individual words.

## Dependencies
NewStats uses `jsoup`, a Java library designed to parse, extract, and manipulate information stored in HTML documents. 
 
## Contributing
Please see `CONTRIBUTING.md` or the issues tab on this repository.