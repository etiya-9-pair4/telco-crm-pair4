import { CapitalizePipe } from './capitalize.pipe';

describe('FormatPipe', () => {
  it('create an instance', () => {
    const pipe = new CapitalizePipe();
    expect(pipe).toBeTruthy();
  });
});
