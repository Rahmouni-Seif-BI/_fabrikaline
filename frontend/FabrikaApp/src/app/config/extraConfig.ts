import { loadCldr, setCulture, setCurrencyCode, L10n } from '@syncfusion/ej2-base';
import * as calendar from './../../../cldr-data/ca-gregorian.json';
import timeZoneNames from './../../../cldr-data/timeZoneNames.json';
import numbers from './../../../cldr-data/numbers.json';
import numberingSystems from './../../../cldr-data/numberingSystems.json';
import weekData from './../../../cldr-data/weekData.json';
import currencies from './../../../cldr-data/currencies.json';

export class extraConfig {
  
  public static basePath = 'https://localhost:4001';
  //public static basePath='http://192.168.31.105/YesBS_X'; //PROD
  //public static basePath='http://yasminees.ddns.net/YesBS_SI'; //YesSI Test Server
  public static formatoptions: Object= { type: 'dateTime', format: 'd/M/y hh:mm:ss' };


  
}
