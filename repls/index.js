import translate from 'google-translate-open-api';
var og = prompt('What are we ruining today?');
console.log(h(og))
function h(hy){
  const result = await translate(`I'm fine.`, {
    tld: "cn",
    to: "zh-CN",
  });
  return result.data[0];
}