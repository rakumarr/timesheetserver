import { TimesheetserveruiPage } from './app.po';

describe('timesheetserverui App', () => {
  let page: TimesheetserveruiPage;

  beforeEach(() => {
    page = new TimesheetserveruiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
