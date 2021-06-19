package dev.spikeysanju.jetquotes.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dev.spikeysanju.jetquotes.repo.UIModeRepo;
import dev.spikeysanju.jetquotes.repo.UIModeRepo_Factory;
import dev.spikeysanju.jetquotes.view.quotes.QuotesScreenComponent;
import dev.spikeysanju.jetquotes.view.quotes.QuotesScreenComponent_MembersInjector;
import dev.spikeysanju.jetquotes.view.splash.SplashScreenComponent;
import dev.spikeysanju.jetquotes.view.splash.SplashScreenComponent_MembersInjector;
import dev.spikeysanju.jetquotes.viewmodel.MainViewModel;
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
public final class DaggerAppComponent implements AppComponent {
  private final DaggerAppComponent appComponent = this;

  private Provider<Preferences> providePreferenceProvider;

  private Provider<UIModeRepo> uIModeRepoProvider;

  private DaggerAppComponent(PreferenceModule preferenceModuleParam) {

    initialize(preferenceModuleParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return new Builder().build();
  }

  private MainViewModel mainViewModel() {
    return new MainViewModel(uIModeRepoProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final PreferenceModule preferenceModuleParam) {
    this.providePreferenceProvider = DoubleCheck.provider(PreferenceModule_ProvidePreferenceFactory.create(preferenceModuleParam));
    this.uIModeRepoProvider = DoubleCheck.provider(UIModeRepo_Factory.create(providePreferenceProvider));
  }

  @Override
  public void inject(SplashScreenComponent splashScreenComponent) {
    injectSplashScreenComponent(splashScreenComponent);
  }

  @Override
  public void inject(QuotesScreenComponent quotesScreen) {
    injectQuotesScreenComponent(quotesScreen);
  }

  private SplashScreenComponent injectSplashScreenComponent(SplashScreenComponent instance) {
    SplashScreenComponent_MembersInjector.injectViewModel(instance, mainViewModel());
    return instance;
  }

  private QuotesScreenComponent injectQuotesScreenComponent(QuotesScreenComponent instance) {
    QuotesScreenComponent_MembersInjector.injectViewModel(instance, mainViewModel());
    return instance;
  }

  public static final class Builder {
    private PreferenceModule preferenceModule;

    private Builder() {
    }

    public Builder preferenceModule(PreferenceModule preferenceModule) {
      this.preferenceModule = Preconditions.checkNotNull(preferenceModule);
      return this;
    }

    public AppComponent build() {
      if (preferenceModule == null) {
        this.preferenceModule = new PreferenceModule();
      }
      return new DaggerAppComponent(preferenceModule);
    }
  }
}
