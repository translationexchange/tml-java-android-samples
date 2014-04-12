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

package com.tr8n.android.samples.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tr8n.android.fragments.Tr8nFragment;
import com.tr8n.android.samples.R;
import com.tr8n.core.Tr8n;

public class WelcomeFragment extends Tr8nFragment {

	private View rootView;
	public WelcomeFragment(){}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
        return rootView;
    }
	
	@Override
	public void onTr8nTranslate() {
		if (rootView == null)
			return;
		
		TextView textView = (TextView) rootView.findViewById(R.id.textview_title);
		textView.setText(Tr8n.translate("Welcome To Tr8n Sample Application"));
		
		textView = (TextView) rootView.findViewById(R.id.textview_intro);
		textView.setText(Tr8n.translate("This application demonstrates some of Tr8n's capabilities.") 
				+ " " + Tr8n.translate("Use the menu on the left to choose a sample."));
	}
	
}
