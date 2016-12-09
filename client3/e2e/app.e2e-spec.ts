import { EmployeeAngularPage } from './app.po';

describe('employee-angular App', function() {
  let page: EmployeeAngularPage;

  beforeEach(() => {
    page = new EmployeeAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
