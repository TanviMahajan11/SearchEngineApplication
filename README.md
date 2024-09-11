# Search Engine Application

This Java application is designed to search for a specified file in two different directories concurrently. It utilizes multithreading to enhance performance by searching both directories at the same time. The application also maintains a log of previously searched files to avoid redundant searches. It reads from a log file to check if the file has been searched before and updates the log with new search results.

# Features 

1) Concurrent Search: Searches for a file in two directories simultaneously using multithreading to speed up the search process.
2) Search History: Logs search results in search_history.log to keep track of previously searched files and their locations.
3) Root Directory Listing: Displays all root directories available on the system, allowing users to see available drives or root directories.
4) File Existence Check: Before performing a new search, checks if the file has already been logged to avoid unnecessary searches.
5) Error Handling: Handles file read/write permissions and search errors gracefully, providing informative error messages
