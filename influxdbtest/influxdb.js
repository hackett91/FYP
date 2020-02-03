const Influx = require('influx');
const influx = new Influx.InfluxDB({
  host: 'localhost',
  database: 'CardiacEvents',
  schema: [
    {
      measurement: 'tide',
      fields: { height: Influx.FieldType.FLOAT },
      tags: ['unit', 'location']
    }
  ]
});

influx.writePoints([
      {
        measurement: 'tide',
        tags: {
          unit: 17,
          location: 11,
        },
        fields: { height: 10 },
        timestamp: 11111,
      }
    ], {
      database: 'CardiacEvents',
      precision: 's',
    })
    .catch(error => {
      console.error(`Error saving data to InfluxDB! ${err.stack}`)
    });
