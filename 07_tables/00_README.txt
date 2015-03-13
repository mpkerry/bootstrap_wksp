Tables

Tables of any complexity present problems for mobile devices. The number of 
columns may not fit elegantly on small screens; the content of individual cells
(headers and/or data) can be too long to display appropriately.

Boostrap handles striping, borders, hovers, and context for you pretty well:

.table
.table-striped
.table-bordered
.table-hover

can all be applied to a table element.


A coherent strategy for showing/hiding individual columns, and modifying the 
contents, has yielded the best results in my experience. Consult hidden-<size> 
and visible-<size> in http://getbootstrap.com/css/#responsive-utilities 

You can also make tables responsive by wrapping in a div with 
class="table-responsive", which will make them horizontally scrollable on 
small devices, if you still need to display all columns.

References
http://getbootstrap.com/css/#tables
http://getbootstrap.com/css/#tables-striped
http://getbootstrap.com/css/#tables-bordered
http://getbootstrap.com/css/#tables-hover-rows
http://getbootstrap.com/css/#tables-responsive

http://getbootstrap.com/css/#responsive-utilities

