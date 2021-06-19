package dev.spikeysanju.jetquotes.view.quotes;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dev.spikeysanju.jetquotes.viewmodel.MainViewModel;
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
public final class QuotesScreenComponent_MembersInjector implements MembersInjector<QuotesScreenComponent> {
  private final Provider<MainViewModel> viewModelProvider;

  public QuotesScreenComponent_MembersInjector(Provider<MainViewModel> viewModelProvider) {
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<QuotesScreenComponent> create(
      Provider<MainViewModel> viewModelProvider) {
    return new QuotesScreenComponent_MembersInjector(viewModelProvider);
  }

  @Override
  public void injectMembers(QuotesScreenComponent instance) {
    injectViewModel(instance, viewModelProvider.get());
  }

  @InjectedFieldSignature("dev.spikeysanju.jetquotes.view.quotes.QuotesScreenComponent.viewModel")
  public static void injectViewModel(QuotesScreenComponent instance, MainViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
