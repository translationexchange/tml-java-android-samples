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

package com.tr8n.android.samples;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tr8n.android.activities.LanguageSelectorActivity;
import com.tr8n.android.activities.Tr8nActivity;
import com.tr8n.android.samples.adapters.NavDrawerListAdapter;
import com.tr8n.android.samples.fragments.CombinedTokensFragment;
import com.tr8n.android.samples.fragments.DataTokensFragment;
import com.tr8n.android.samples.fragments.DecorationTokensFragment;
import com.tr8n.android.samples.fragments.WelcomeFragment;
import com.tr8n.android.samples.models.NavDrawerItem;
import com.tr8n.core.Tr8n;

public class MainActivity extends Tr8nActivity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	
	private ArrayList<NavDrawerItem> navDrawerItems;
	
	private List<NavDrawerItem> getNavDrawerItems() {
		if (navDrawerItems == null) {
			navDrawerItems = new ArrayList<NavDrawerItem>();
			navDrawerItems.add(new NavDrawerItem("Welcome", WelcomeFragment.class.getName()));
			navDrawerItems.add(new NavDrawerItem("Data Tokens Demo", DataTokensFragment.class.getName()));
			navDrawerItems.add(new NavDrawerItem("Decoration Tokens Demo", DecorationTokensFragment.class.getName()));
			navDrawerItems.add(new NavDrawerItem("Combined Tokens Demo", CombinedTokensFragment.class.getName()));
		}
		return navDrawerItems;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		mTitle = mDrawerTitle = getTitle();
		
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
		mDrawerList.setAdapter(new NavDrawerListAdapter(getApplicationContext(), getNavDrawerItems()));
		mDrawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				displayView(position);
			}
		});
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
//		getActionBar().setHomeButtonEnabled(true);
	
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	
		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
			case R.id.change_language:
		    	startActivity(new Intent(MainActivity.this, LanguageSelectorActivity.class));
				return true;
			case R.id.inline_translator:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Tr8n.getSession().getApplication().getHost() + "/mobile/login")));				
//		    	startActivity(new Intent(MainActivity.this, InAppTranslatorActivity.class));
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		MenuItem menuItem = (MenuItem) menu.findItem(R.id.change_language);
		menuItem.setVisible(!drawerOpen);
		menuItem.setTitle("Change Language");
		menuItem = (MenuItem) menu.findItem(R.id.inline_translator);
		menuItem.setVisible(!drawerOpen);
		menuItem.setTitle("Translate");
		return super.onPrepareOptionsMenu(menu);
	}
	
	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		
		NavDrawerItem item = getNavDrawerItems().get(position);
		Fragment fragment = item.getFragment();
		
		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
			setTitle(item.getTitle());
			
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
	
	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public void onTr8nTranslate() {
		((NavDrawerListAdapter)mDrawerList.getAdapter()).notifyDataSetChanged();
	}

	@Override
	public void registerSources() {
	}
}

