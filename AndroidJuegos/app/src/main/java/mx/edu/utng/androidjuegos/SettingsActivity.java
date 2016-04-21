package mx.edu.utng.androidjuegos;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;

import java.util.List;

/**
 * Creado por Juan Gabriel Carrillo Avalos.
 */

/**

 * Un enlace @ { } PreferenceActivity que presenta un conjunto de parámetros de la aplicación . En
 * Los dispositivos de teléfonos móviles , los ajustes se presentan como una lista única. En las tabletas ,
 * ajustes están divididos por categoría, con categoría encabezados que se muestran a la izquierda de
 * La lista de ajustes .
 * < P >
 * Ver <a href="http://developer.android.com/design/patterns/settings.html">
 * Diseño Android : Ajustes </a> para guías de diseño y la <a
 * href = " "> Ajustes http://developer.android.com/guide/topics/ui/settings.html~~number=plural
 * </a> Guía de API para obtener más información sobre el desarrollo de una interfaz de usuario Configuración.
 */
public class SettingsActivity extends AppCompatPreferenceActivity {
    /**
     * Determina si se debe mostrar siempre la interfaz de usuario de configuración simplificada , donde
     * ajustes se presentan en una lista única. Cuando falsa , se muestran los ajustes
     * Como un / detalle vista de dos paneles principal en tabletas . Cuando es verdadero , es un único panel
     * Se muestra en las tabletas
     */
    private static final boolean ALWAYS_SIMPLE_PREFS = false;
    /**
     * Un cambio oyente valor de preferencia que actualiza el resumen de la preferencia
     * Para reflejar su nuevo valor .
     */
    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();

            if (preference instanceof ListPreference) {
                // Para las preferencias de la lista, buscar el valor correcto en la pantalla
                // Lista de la preferencia ' entradas ' .
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);

                // Establecer el resumen para reflejar el nuevo valor .
                preference.setSummary(
                        index >= 0
                                ? listPreference.getEntries()[index]
                                : null);

            } else if (preference instanceof RingtonePreference) {
                // Para las preferencias de tono de llamada , buscar el valor de visualización correcta
                // Usando RingtoneManager .
                if (TextUtils.isEmpty(stringValue)) {
                    // Valores vacíos corresponden a "silenciosa" (sin tono ) .
                    preference.setSummary(R.string.pref_ringtone_silent);

                } else {
                    Ringtone ringtone = RingtoneManager.getRingtone(
                            preference.getContext(), Uri.parse(stringValue));

                    if (ringtone == null) {
                        // Borrar el resumen si había un error de búsqueda .
                        preference.setSummary(null);
                    } else {
                        // Establecer el resumen para reflejar el nuevo tono de timbre pantalla
                        // nombre.
                        String name = ringtone.getTitle(preference.getContext());
                        preference.setSummary(name);
                    }
                }

            } else {
                // Para todas las demás preferencias , establecer el resumen con el valor de
                // Representación de cadena simple .
                preference.setSummary(stringValue);
            }
            return true;
        }
    };

    /**
     * Método auxiliar para determinar si el dispositivo tiene una pantalla extra - grande. por
     * Ejemplo, 10 "tabletas son extra - grande.
     */
    private static boolean isXLargeTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }

    /**
     * Determina si la configuración de la interfaz de usuario simplificada se debe mostrar . Esto es
     * Cierto si este es forzado a través de { @ link #ALWAYS_SIMPLE_PREFS } , o el dispositivo
     * No tiene APIs nuevas como { @ link PreferenceFragment } , o el dispositivo
     * No tiene una pantalla extra - grande. En estos casos, un solo panel
     * " Simplificado" configuración de la interfaz de usuario se debe mostrar .
     */
    private static boolean isSimplePreferences(Context context) {
        return ALWAYS_SIMPLE_PREFS
                || Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB
                || !isXLargeTablet(context);
    }

    /**
     * Se une un resumen de la preferencia a su valor . Más específicamente, cuando la
     * El valor de preferencia se cambia , su resumen ( línea de texto debajo de la
     * Título de preferencia) se actualiza para reflejar el valor . El resumen es también
     * Inmediatamente actualizada al llamar a este método . El formato de visualización es exacta
     * Depende del tipo de preferencia.
     *
     *
     */
    private static void bindPreferenceSummaryToValue(Preference preference) {
        // Establecer el oyente para observar los cambios de valor
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Desencadenar el oyente de inmediato con la preferencia de
        // valor actual.

        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
    }

    /**
     * Puesta en funcionamiento del enlace @ { } android.app.ActionBar , si la API está disponible .
     */
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setupSimplePreferencesScreen();
    }

    /**
     * Muestra la configuración de la interfaz de usuario simplificada si la configuración del dispositivo si la
     * Configuración del dispositivo dicta que una simplificada , la interfaz de usuario de un solo panel debe ser
     * mostrado.
     */
    private void setupSimplePreferencesScreen() {
        if (!isSimplePreferences(this)) {
            return;
        }

        // En la interfaz de usuario simplificada , los fragmentos no se utilizan en absoluto y que en su lugar
        // Uso del antiguo API PreferenceActivity .

        // Añadir preferencias "generales" .
        addPreferencesFromResource(R.xml.pref_general);

        // Añadir preferencias ' Notificaciones' , y una cabecera correspondiente .
        PreferenceCategory fakeHeader = new PreferenceCategory(this);
        fakeHeader.setTitle(R.string.pref_header_notifications);
        getPreferenceScreen().addPreference(fakeHeader);
        addPreferencesFromResource(R.xml.pref_notification);

        // Add 'data and sync' preferences, and a corresponding header.
        fakeHeader = new PreferenceCategory(this);
        fakeHeader.setTitle(R.string.pref_header_data_sync);
        getPreferenceScreen().addPreference(fakeHeader);
        addPreferencesFromResource(R.xml.pref_data_sync);

        // Bind the summaries of EditText/List/Dialog/Ringtone preferences to
        // their values. When their values change, their summaries are updated
        // to reflect the new value, per the Android Design guidelines.
        bindPreferenceSummaryToValue(findPreference("example_text"));
        bindPreferenceSummaryToValue(findPreference("example_list"));
        bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"));
        bindPreferenceSummaryToValue(findPreference("sync_frequency"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onIsMultiPane() {
        return isXLargeTablet(this) && !isSimplePreferences(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onBuildHeaders(List<PreferenceActivity.Header> target) {
        if (!isSimplePreferences(this)) {
            loadHeadersFromResource(R.xml.pref_headers, target);
        }
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    protected boolean isValidFragment(String fragmentName) {
        return PreferenceFragment.class.getName().equals(fragmentName)
                || GeneralPreferenceFragment.class.getName().equals(fragmentName)
                || DataSyncPreferenceFragment.class.getName().equals(fragmentName)
                || NotificationPreferenceFragment.class.getName().equals(fragmentName);
    }

    /**
     * This fragment shows general preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class GeneralPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);
            setHasOptionsMenu(true);

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            bindPreferenceSummaryToValue(findPreference("example_text"));
            bindPreferenceSummaryToValue(findPreference("example_list"));
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * This fragment shows notification preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class NotificationPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_notification);
            setHasOptionsMenu(true);

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"));
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * This fragment shows data and sync preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class DataSyncPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_data_sync);
            setHasOptionsMenu(true);

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            bindPreferenceSummaryToValue(findPreference("sync_frequency"));
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }
}
