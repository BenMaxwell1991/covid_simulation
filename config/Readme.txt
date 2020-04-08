When specifiying the population parameters, the tranmission rates should be handled as follows:

Example Transmission Rate JSon Object:

  "transmissionRates": [
    [				This is group 0
      1.0,		Transmission rate 0 --> 0 (Internal)
      2.0,		Transmission rate 0 --> 1 (External)
      3.0 		Transmission rate 0 --> 2 (External)
    ],
    [				This is group 1
      1.5,		Transmission rate 1 --> 0 (External)
      1.2,		Transmission rate 1 --> 1 (Internal)
      1.2		Transmission rate 1 --> 2 (External)
    ]
    [				This is group 2
      1.5,		Transmission rate 2 --> 0 (External)
      1.2,		Transmission rate 2 --> 1 (External)
      1.2		Transmission rate 2 --> 2 (Internal)
    ]
  ]

This can be scaled up for any number of groups. It amounts to a transmission matrix of [n][n].
A value (double) must be entered for every element of the matrix.