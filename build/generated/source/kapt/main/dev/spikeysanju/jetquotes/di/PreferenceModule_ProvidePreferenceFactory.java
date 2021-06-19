package dev.spikeysanju.jetquotes.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.prefs.Preferences;
import javax.annotation.processing.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PreferenceModule_ProvidePreferenceFactory implements Factory<Preferences> {
  private final PreferenceModule module;

  public PreferenceModule_ProvidePreferenceFactory(PreferenceModule module) {
    this.module = module;
  }

  @Override
  public Preferences get() {
    return providePreference(module);
  }

  public static PreferenceModule_ProvidePreferenceFactory create(PreferenceModule module) {
    return new PreferenceModule_ProvidePreferenceFactory(module);
  }

  public static Preferences providePreference(PreferenceModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providePreference());
  }
}
