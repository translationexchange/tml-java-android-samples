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

import com.translationexchange.core.Tml;
import com.translationexchange.core.Utils;
import com.translationexchange.android.samples.models.Sample;

public class DataTokensFragment extends SamplesFragment {
	
	public DataTokensFragment(){}
	
	protected List<Sample> getSamples() {
		if (samples == null) {
			samples = new ArrayList<Sample>();
			samples.add(new Sample("Hello {user}", Utils.buildMap("user", "Michael")));
			
			samples.add(new Sample("You have selected {language_name} languge", 
					Utils.buildMap("language_name", Tml.getCurrentLanguage().getEnglishName())));
			samples.add(new Sample("Number of messages: {count}", Utils.buildMap("count", 5)));

			samples.add(new Sample("Hello {user.name}, you are a {user.gender}", 
					Utils.buildMap("user", Utils.buildMap("name", "Michael", "gender", "male"))));

			samples.add(new Sample("You have {count||message}", Utils.buildMap("count", 1)));
			samples.add(new Sample("You have {count||message}", Utils.buildMap("count", 5)));
			samples.add(new Sample("{user| He, She} likes this movie.", Utils.buildMap("user", Utils.buildMap("gender", "male"))));
 			
			samples.add(new Sample("{user} uploaded {count|| photo} to {user| his, her} photo album.", 
					Utils.buildMap(
							"user", Utils.buildMap(
										"object", Utils.buildMap("name", "Michael", "gender", "male"),
										"attribute", "name"
									),
							"count", 1
							)));
			
		}
		
		return samples;
	}

}
