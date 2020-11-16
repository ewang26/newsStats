# NewsStats
NewsStats is a Java library that is designed to fetch information from a url (primarily Google News and Yahoo News) and analyze the content on the webpage. 

## Where the Information Comes From
Like other standard websites, most online news aggregator services display all of their information and articles using HTML source code. NewsStats accesses this HTML content from different online news sites, such as Google News and Yahoo News, using a library called jsoup. Jsoup allows this library to conveniently analyze the headers in the news pages using H3 and H4 HTML tags. Thus, NewsStats is able to quickly and cleanly identify the key terms in a news page by ranking the frequency of individual words.

## How NewsStats Works
NewsStats stores all of the H3 and H4 HTML tags (which are the news article headers) in a list, which is then split into individual words. However, if the strings contain a word that is part of the predefined list of filler words, it will just ignore that specific word and store the rest of the string's words as well as their corresponding frequency throughout the news webpage (article titles only) in a hashmap. The word and its corresponding frequency is stored as a 'WordCount' object. Ultimately, running 'AnalyzeNewsMain.java' will return the top twenty most popular words and their frequency.

## Dependencies
NewStats uses `jsoup`, a Java library designed to parse, extract, and manipulate information stored in HTML documents. 
 
## Contributing
Please see [CONTRIBUTING.md](https://github.com/ewang26/newsStats/blob/gradle-packaged/CONTRIBUTING.md) or the [Issues tab](https://github.com/ewang26/newsStats/issues) on this repository.