package com.creative.hub.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceCategory;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;
import android.provider.Settings;
import com.android.settings.R;

import java.util.Locale;
import android.text.TextUtils;
import android.view.View;

import com.android.settings.SettingsPreferenceFragment;
import com.creative.hub.preferences.CustomSeekBarPreference;
import com.creative.hub.preferences.SystemSettingSeekBarPreference;
import com.creative.hub.preferences.SystemSettingListPreference;
import com.creative.hub.preferences.SystemSettingSwitchPreference;
import com.creative.hub.preferences.SystemSettingMasterSwitchPreference;
import com.android.settings.Utils;
import com.android.internal.util.creative.CreativeUtils;
import android.util.Log;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;
import android.provider.SearchIndexableResource;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@SearchIndexable(forTarget = SearchIndexable.ALL & ~SearchIndexable.ARC)
public class StatusBarSettings extends SettingsPreferenceFragment implements
        OnPreferenceChangeListener {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        addPreferencesFromResource(R.xml.creativehub_statusbar);
		
		ContentResolver resolver = getActivity().getContentResolver();

        PreferenceScreen prefSet = getPreferenceScreen();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {
        ContentResolver resolver = getActivity().getContentResolver();
        return false;
    }
	
    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.CREATIVE;
    }
	
	/**
     * For Search.
     */

    public static final SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider() {

                @Override
                public List<SearchIndexableResource> getXmlResourcesToIndex(Context context,
                        boolean enabled) {
                    ArrayList<SearchIndexableResource> result =
                            new ArrayList<SearchIndexableResource>();
                    SearchIndexableResource sir = new SearchIndexableResource(context);
                    sir.xmlResId = R.xml.creativehub_statusbar;
                    result.add(sir);
                    return result;
                }

                @Override
                public List<String> getNonIndexableKeys(Context context) {
                    List<String> keys = super.getNonIndexableKeys(context);
                    return keys;
                }
    };

}
