/*
Template Name: Admin Pro Admin
Author: Wrappixel
Email: niravjoshi87@gmail.com
File: js
*/
$(function () {
    "use strict";
    // ============================================================== 
    // Our Visitor
    // ============================================================== 

    // var chart = c3.generate({
    //     bindto: '#visitor',
    //     data: {
    //         columns: [
    //             ['Other', 30],
    //             ['Mượn', 10],
    //             ['Nhập', 40],
    //             ['Trả', 50],
    //         ],

    //         type: 'donut',
    //         onclick: function (d, i) { console.log("onclick", d, i); },
    //         onmouseover: function (d, i) { console.log("onmouseover", d, i); },
    //         onmouseout: function (d, i) { console.log("onmouseout", d, i); }
    //     },
    //     donut: {
    //         label: {
    //             show: false
    //         },
    //         title: "Visits",
    //         width: 20,

    //     },

    //     legend: {
    //         hide: true
    //         //or hide: 'data1'
    //         //or hide: ['data1', 'data2']
    //     },
    //     color: {
    //         pattern: ['#eceff1', '#24d2b5', '#6772e5', '#20aee3']
    //     }
    // });
    // ============================================================== 
    // Our Income
    // ==============================================================
    var chart = c3.generate({
        bindto: '#income',
        data: {
            columns: [
                ['Growth Income', 100, 200, 100, 300],
                ['Net Income', 130, 100, 140, 200]
            ],
            type: 'bar'
        },
        bar: {
            space: 0.2,
            // or
            width: 15 // this makes bar width 100px
        },
        axis: {
            y: {
                tick: {
                    count: 4,

                    outer: false
                }
            }
        },
        legend: {
            hide: true
            //or hide: 'data1'
            //or hide: ['data1', 'data2']
        },
        grid: {
            x: {
                show: false
            },
            y: {
                show: true
            }
        },
        size: {
            height: 290
        },
        color: {
            pattern: ['#24d2b5', '#20aee3']
        }
    });

    // ============================================================== 
    // Sales Different
    // ============================================================== 

    var chart = c3.generate({
        bindto: '#sales',
        data: {
            columns: [
                ['One+', 50],
                ['T', 60],
                ['Samsung', 20],

            ],

            type: 'donut',
            onclick: function (d, i) { console.log("onclick", d, i); },
            onmouseover: function (d, i) { console.log("onmouseover", d, i); },
            onmouseout: function (d, i) { console.log("onmouseout", d, i); }
        },
        donut: {
            label: {
                show: false
            },
            title: "",
            width: 18,

        },
        size: {
            height: 150
        },
        legend: {
            hide: true
            //or hide: 'data1'
            //or hide: ['data1', 'data2']
        },
        color: {
            pattern: ['#eceff1', '#24d2b5', '#6772e5', '#20aee3']
        }
    });
    // ============================================================== 
    // Sales Prediction
    // ============================================================== 

    var chart = c3.generate({
        bindto: '#prediction',
        data: {
            columns: [
                ['data', 91.4]
            ],
            type: 'gauge',
            onclick: function (d, i) { console.log("onclick", d, i); },
            onmouseover: function (d, i) { console.log("onmouseover", d, i); },
            onmouseout: function (d, i) { console.log("onmouseout", d, i); }
        },

        color: {
            pattern: ['#ff9041', '#20aee3', '#24d2b5', '#6772e5'], // the three color levels for the percentage values.
            threshold: {
                //            unit: 'value', // percentage is default
                //            max: 200, // 100 is default
                values: [30, 60, 90, 100]
            }
        },
        gauge: {
            width: 22,
        },
        size: {
            height: 120,
            width: 150
        }
    });
    setTimeout(function () {
        chart.load({
            columns: [
                ['data', 10]
            ]
        });
    }, 1000);

    setTimeout(function () {
        chart.load({
            columns: [
                ['data', 50]
            ]
        });
    }, 2000);

    setTimeout(function () {
        chart.load({
            columns: [
                ['data', 70]
            ]
        });
    }, 3000);

    // ============================================================== 
    // Sales chart
    // ============================================================== 
    // var day_data = [
    //     { "period": "2012-10-02", "nhap": 0, "muon": 0, "tra": 0 },
    //     { "period": "2012-10-01", "nhap": 50, "muon": 80, "tra": 20 },
    //     { "period": "2012-09-30", "nhap": 50, "muon": 80, "tra": 20 },
    //     { "period": "2012-09-29", "nhap": 50, "muon": 80, "tra": 20 },
    //     { "period": "2012-09-20", "nhap": 50, "muon": 50, "tra": 20 },
    //     { "period": "2012-09-19", "nhap": 10, "muon": 80, "tra": 20 },
    //     { "period": "2012-09-18", "nhap": 50, "muon": 30, "tra": 20 },
    //     { "period": "2012-09-17", "nhap": 50, "muon": 80, "tra": 20 },
    //     { "period": "2012-09-16", "nhap": 50, "muon": 80, "tra": 50 },
    //     { "period": "2012-09-15", "nhap": 50, "muon": 80, "tra": 20 },
    //     { "period": "2012-09-10", "nhap": 50, "muon": 80, "tra": 20 }
    // ];
    // Morris.Area({
    //     element: 'sales-chart',
    //     data: day_data,
    //     xkey: 'period',
    //     ykeys: ['nhap', 'muon', 'tra'],
    //     labels: ['Nhập', 'Mượn', 'Trả'],
    //     pointSize: 0,
    //     fillOpacity: 0,
    //     pointStrokeColors: ['#20aee3', '#24d2b5', '#6772e5'],
    //     behaveLikeLine: true,
    //     gridLineColor: '#e0e0e0',
    //     lineWidth: 3,
    //     hideHover: 'auto',
    //     lineColors: ['#20aee3', '#24d2b5', '#6772e5'],
    //     resize: true

    // });


});