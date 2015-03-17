-Images

Bootstrap makes images responsive with class="img-responsive". However, this only affects the scaling of the image on a mobile device, not the  size of the image itself. For that, we need other tools.

The simplest approach for dealing with size is srcset:

<pre>
<img
	srcset="some_image_large.jpg 1920w,
			some_image_medium.jpg 960w,
			some_image_small.jpg 480w "
	src="some_image_medium.jpg"
	alt="meaningful description of 'some image' in context of page"
/>
</pre>
	
However, srcset is not supported across all browsers. Sigh. Works great in Chrome, not yet really in Firefox, although theoretically version 38 of FF will include support. IE? Ha :) Safari? Incomplete support (only x attributes, not the w attributes as above)

Note that in the absence of support for srcset that the above tag does have a src attribute, so will not fail completely; it also has an alt tag for browsers without any support for images (and screenreaders).

The picture tag, while a more versatile option, is also only supported fully in Chrome. You will need a fallback strategy.

-Glyphicons
Bootstrap generously includes over 250 glyphs free of charge. Please use them where appropriate, while taking care to provide for users of assistive technologies.

N.B. they must not be mixed with other components, and are only for use on empty elements. See http://getbootstrap.com/components/#glyphicons-how-to-use for more detail.

-References

http://alistapart.com/article/responsive-images-in-practice

Bootstrap Images
http://getbootstrap.com/css/#images
http://getbootstrap.com/css/#images-responsive
http://getbootstrap.com/css/#images-shapes

Bootstrap Glyphicons
http://getbootstrap.com/components/#glyphicons
http://getbootstrap.com/components/#glyphicons-how-to-use
http://getbootstrap.com/components/#glyphicons-examples

Availability of support varies:
http://caniuse.com/#feat=srcset
http://caniuse.com/#feat=picture

