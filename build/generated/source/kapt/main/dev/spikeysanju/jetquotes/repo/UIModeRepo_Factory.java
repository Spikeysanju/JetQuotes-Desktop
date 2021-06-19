package dev.spikeysanju.jetquotes.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import java.util.prefs.Preferences;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UIModeRepo_Factory implements Factory<UIModeRepo> {
  private final Provider<Preferences> prefProvider;

  public UIModeRepo_Factory(Provider<Preferences> prefProvider) {
    this.prefProvider = prefProvider;
  }

  @Override
  public UIModeRepo get() {
    return newInstance(prefProvider.get());
  }

  public static UIModeRepo_Factory create(Provider<Preferences> prefProvider) {
    return new UIModeRepo_Factory(prefProvider);
  }

  public static UIModeRepo newInstance(Preferences pref) {
    return new UIModeRepo(pref);
  }
}
