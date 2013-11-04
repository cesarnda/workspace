var http = require('http'); // Built-in http module provides HTTP server and client functionality

var fs = require('fs'); // Built-in fs module provides filesystem-related functionality

var path = require('path'); //Built-in path module provides filesystem path-related functionality

var mime = require('mime'); // Add-on mime module provides ability to derive a MIME type based on a filename extension

var cache = {}; // cache object is where the contents of cached files are stored

function send404(response){
	response.writeHead(404, {'Content-Type': 'text/plain'});
	response.write('Error 404: resource not found.');
	response.end();
}

function sendFile(response, filePath, fileContents){
	
}