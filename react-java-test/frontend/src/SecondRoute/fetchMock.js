export default function () {
  return Promise.resolve({
    text: () => Promise.resolve(
      'hello',
    ),
  });
}
