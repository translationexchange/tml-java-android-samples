/*
 *  Copyright (c) 2014 Michael Berkovich, http://tr8nhub.com All rights reserved.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.translationexchange.android.samples.fragments;

import java.util.ArrayList;
import java.util.List;

import com.translationexchange.core.Utils;
import com.translationexchange.android.samples.models.HtmlSample;
import com.translationexchange.android.samples.models.Sample;
import com.translationexchange.android.samples.models.SpannedSample;

public class DecorationTokensFragment extends SamplesFragment {
	
	public DecorationTokensFragment(){}
	
	protected List<Sample> getSamples() {
		if (samples == null) {
			samples = new ArrayList<Sample>();
			
			samples.add(new SpannedSample("[bold: Adjust color] using SpannableString.", Utils.buildMap("bold", Utils.buildMap(
					"color", "red"
			))));
			
//			samples.add(new AttributedStringSample("[bold: Adjust fonts] using an attribute dictionary.", 
//					Utils.buildMap(
//							"bold", Utils.buildMap(
//									"font", Utils.buildMap("family", "Helvetica", "style", "bold", "size", 15)
//							)
//					)
//			));
//
//			samples.add(new AttributedStringSample("System [bold: bold font] followed by [italic: italic font].", 
//					Utils.buildMap(
//							"bold", Utils.buildMap(
//									"font", Utils.buildMap("family", "Helvetica", "style", "bold", "size", 15)
//							),
//							"italic", Utils.buildMap(
//									"font", Utils.buildMap("family", "Helvetica", "style", "italic", "size", 15)
//							)
//					)
//			));
			
			samples.add(new HtmlSample("[bold: Adjust fonts] using HTML.", Utils.buildMap("bold", "<strong>{$0}</strong>")));
			samples.add(new HtmlSample("[red: Change color] using HTML.", Utils.buildMap("red", "<font color='red'>{$0}</font>")));
			samples.add(new HtmlSample("Nest [bold]some bold and [italic: italic][/bold] using HTML.", Utils.buildMap("italic", "<i>{$0}</i>", "bold", "<strong>{$0}</strong>")));
		}
		
		return samples;
	}

}
