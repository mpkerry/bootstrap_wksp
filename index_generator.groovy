/**
 * link_generator.groovy
 * generate index page for abcd mobile workshop
 */
 
def f = new File(".")
def srcDir = f.absolutePath
srcDir = srcDir.substring(0,srcDir.length()-1)


f.eachFile { dir ->

    if (dir.isDirectory() && dir.name.charAt(0) != '.') {


        dir.eachFile { file ->
            if (file.name.contains("00_README.txt")) {
            
            def dest = new File(dir, "index.html")
            def pw = new PrintWriter(dest)
            def fileName = dir.absolutePath.replace(srcDir,'')
            fileName = fileName.replace ('./', '')
            fileName = fileName.replace ('_', ' ')            
            pw.println "<!DOCTYPE html>\n<html>\n<head>\n<title>$fileName</title>\n"
            pw.println new File("00_resources/cdn_css.txt").text
            pw.println"</head>"
            pw.println "<body>\n<div class=\"container\">\n"

            pw.println "<div class=\"jumbotron\" style=\"background-color: #293352 !important; color: #F4EDCA !important; border: medium solid #4E84C4 !important;\">"
            pw.println "<h1>Bootstrap Workshop</h1>\n<h2>${fileName}</h2>\n</div>"
            
            def list = false
            def pre = false            
            file.eachLine { line ->

                if (line) {
                    if (line.startsWith('<pre>')) {
                        pw.println line
                        pre = true
                    } else if (line.startsWith('</pre>')) {
                        pw.println line
                        pre = false
                    } else {
                    
                    line = line.replaceAll('<img', '&lt;img')
                    line = line.replaceAll('/>', '/&gt;')
                    
                    if (pre) {
                      pw.println line                 
                    } else if (line.startsWith('-')) {
                        pw.println("<h2>${line.substring(1)}</h2>")
                    
                    } else if (line.startsWith('http')) {
                        pw.println "<a href=\"$line\" target=\"_blank\">$line</a><br/>"                    
                    } else {
                        if (line.startsWith('*')) {
                            if (!list) {
                                pw.println("<ul>")
                            } 
                            list = true 
                        } else {
                            if (list) {
                                pw.println("</ul>")
                            } 
                            list = false 
                        }
                        if (list) {
                            pw.println "<li>${line.substring(1)}</li>"
                        } else {
                            pw.println("<p>$line</p>")
                        }
                    }
                }
                }
            }
                
            pw.println "\n</div>"
            pw.println new File("00_resources/cdn_js.txt").text
            pw.println "\n</body>\n</html>"
            pw.close()
                
            }
        }
    }
}
