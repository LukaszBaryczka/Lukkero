import { LukkeroPage } from './app.po';

describe('lukkero App', () => {
  let page: LukkeroPage;

  beforeEach(() => {
    page = new LukkeroPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
