package dev.spikeysanju.jetquotes.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dev.spikeysanju.jetquotes.repo.UIModeRepo;
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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<UIModeRepo> repoProvider;

  public MainViewModel_Factory(Provider<UIModeRepo> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static MainViewModel_Factory create(Provider<UIModeRepo> repoProvider) {
    return new MainViewModel_Factory(repoProvider);
  }

  public static MainViewModel newInstance(UIModeRepo repo) {
    return new MainViewModel(repo);
  }
}
