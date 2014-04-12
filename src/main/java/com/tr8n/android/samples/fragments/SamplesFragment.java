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

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.tr8n.android.fragments.Tr8nFragment;
import com.tr8n.android.samples.R;
import com.tr8n.android.samples.adapters.SampleListAdapter;
import com.tr8n.android.samples.models.Sample;

public abstract class SamplesFragment extends Tr8nFragment {

	protected ListView samplesList;
	protected List<Sample> samples;
	
	public SamplesFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_samples, container, false);
        
        samplesList = (ListView) rootView.findViewById(R.id.listview_samples);
        samplesList.setAdapter(new SampleListAdapter(getActivity().getApplicationContext(), getSamples()));
        
        return rootView;
    }
	
	protected abstract List<Sample> getSamples();

	@Override
	public void onTr8nTranslate() {
		((SampleListAdapter)samplesList.getAdapter()).notifyDataSetChanged();
	}
	
	@Override
	public void registerSources() {
		
	}
	
}
