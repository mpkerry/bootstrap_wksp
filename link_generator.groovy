/**
 * link_generator.groovy
 * generate index page for abcd mobile workshop
 */
 
def f = new File(".")
def srcDir = f.absolutePath
srcDir = srcDir.substring(0,srcDir.length()-1)

def dest = new File("index.html")
def pw = new PrintWriter(dest)
pw.println "<!DOCTYPE html>\n<html>\n<head>\n<title>Bootstrap WKSP - Links to exercises</title>\n"
pw.println new File("00_resources/cdn_css.txt").text
pw.println "<meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0\">"
pw.println"<style>\n\t.hider { font-size: .65em !important; } \n\t.normal {font-size: 1em !important; }\n</style>\n</head>"
pw.println "<body>\n<div class=\"container\">\n"
pw.println "<div class=\"jumbotron\">\n<h1>Bootstrap Workshop</h1>\n<h2>Instructions, Resources, Tools, and Links to exercises</h2>\n<p class=\"normal pull-right\">Created for ABCD bootstrap wksp 3/19/2015</p>\n</div>"


pw.println "<h3>Exercises to familiarize you with Bootstrap essentials.</h3>"

pw.println new File("tools.html").text

pw.println new File("instructions.html").text

pw.println new File ("links.html").text

pw.println "<h3>Happy coding!</h3>"

int counter = 0
def tablist = ['00','01-04','05-08','09']

pw.println "                <div role=\"tabpanel\">"

pw.println "                  <!-- Nav tabs -->"
pw.println "                  <ul class=\"nav nav-tabs\" role=\"tablist\">"
pw.println "                    <li role=\"presentation\" class=\"active\"><a href=\"#${tablist[0]}\" aria-controls=\"${tablist[0]}\" role=\"tab\" data-toggle=\"tab\">${tablist[0]}</a></li>"
pw.println "                    <li role=\"presentation\"><a href=\"#${tablist[1]}\" aria-controls=\"${tablist[1]}\" role=\"tab\" data-toggle=\"tab\">${tablist[1]}</a></li>"
pw.println "                    <li role=\"presentation\"><a href=\"#${tablist[2]}\" aria-controls=\"${tablist[2]}\" role=\"tab\" data-toggle=\"tab\">${tablist[2]}</a></li>"
pw.println "                    <li role=\"presentation\"><a href=\"#${tablist[3]}\" aria-controls=\"${tablist[3]}\" role=\"tab\" data-toggle=\"tab\">${tablist[3]}</a></li>"
pw.println "                  </ul>"
            
                
pw.println "                  <!-- Tab panes -->"
pw.println "                  <div class=\"tab-content\">"

pw.println "\n<div role=\"tabpanel\" class=\"tab-pane active\" id=\"${tablist[0]}\">"
pw.println "<p>&nbsp;</p>"
pw.println "<div class=\"row\">\n"
f.eachFile { dir ->

    if (dir.isDirectory() && dir.name.charAt(0) != '.') {

        if (counter%4 == 1) {
            pw.println "\n<div role=\"tabpanel\" class=\"tab-pane\" id=\"${tablist[(int)(counter/4)+1]}\">"
            pw.println "<p>&nbsp;</p>"
            pw.println "<div class=\"row\">\n"
        }
        
        def dirNum = dir.name.split('_')[0]
        def dirName = dir.name.split('_')[1]
        pw.println "<div class=\"col-sm-3\">"
        
        pw.println " <div class=\"hidden-xs\">"
        pw.println "       <svg height=\"140\" width=\"140\">"
        pw.println "    <title>$dirNum</title>"
        pw.println "    <desc>Section ${dirNum}: ${dirName}</desc>"
        pw.println "    <circle cx=\"70\" cy=\"70\" r=\"68\" stroke=\"grey\" stroke-width=\"3\" fill=\"grey\" />"
        pw.println "    <text x=\"${70-7*dirName.length()}\" y=\"75\" fill=\"white\" style=\"font-size: 2em;\">${dirName}</text>"
        pw.println "</svg>"
        
        
        pw.println "</div>"
      

        
        pw.println"<h3><a href=\"${dir.name}/index.html\" target=\"_blank\"><span class=\"hidden-xs\">start</span><span class=\"visible-xs\">${dirName}</span></a> </h3>"
        pw.println "\t<ul class=\"list-unstyled\">"
        dir.eachFile { file ->
            if ((file.name.contains(".txt") || file.name.contains(".html") || file.name.contains(".css") || file.name.contains(".js")) &&
                !file.name.contains("index") && !file.name.contains("READ")) {
                def fileName = file.absolutePath.replace(srcDir,'')
                pw.println "\t\t<li><a href=\"$fileName\" target=\"_blank\">$file.name</a></li> "
                if (fileName.contains('DONE')) { pw.println "\t\t<li>&nbsp;</li>" }
            }
        }
        pw.println "\t</ul>\n</div>\n"
        if (counter%4 == 0) {
            pw.println "</div><!-- end of row -->"
            pw.println "</div><!-- end of tab pane -->\n"
        }
        counter++
    }
}
pw.println "\n</div>\n</div>"
pw.println new File("00_resources/cdn_js.txt").text
pw.println "\n</body>\n</html>"
pw.close()